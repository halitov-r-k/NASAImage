package halitov.netlogy;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;

public class TelegramBot extends TelegramLongPollingBot {

    private static final String BOT_TOKEN = "5727044463:AAFLV__0-mQxAGrrUgBjwuMqjPkXHBJzLAU";
    private static final String BOT_USERNAME = "RuslanHalitov_bot";

    private static final String URL = "https://api.nasa.gov/planetary/apod?api_key=Ad5FiPZWPYc2xB330H839WyrrNP3f349TJbsBBq4";

    private static long chatId;

    public TelegramBot() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(this);

    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()) {
            chatId = update.getMessage().getChatId();

            switch (update.getMessage().getText()) {
                case "/start":
                    sendMessage("Привет я бот, который присылает картинку от NASA");
                    break;
                case "/help":
                    sendMessage("Чтобы получить картинку введи /give");
                    break;
                case "/give":
                    try{
                        sendMessage(Utils.getUrl(URL));
                    } catch (IOException e) {
                        throw new RuntimeException((e));
                    }
                    break;
                default:
                    sendMessage("Моя твоя не понимай");


            }

        }
    }

    private void sendMessage(String messageText) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(messageText);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
