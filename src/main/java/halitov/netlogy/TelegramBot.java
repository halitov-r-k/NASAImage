package halitov.netlogy;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramBot extends TelegramLongPollingBot {

    private static final String BOT_TOKEN ="5727044463:AAFLV__0-mQxAGrrUgBjwuMqjPkXHBJzLAU";
    private static final String BOT_USERNAME = "RuslanHalitov_bot";

    private static final String URL = "https://api.nasa.gov/planetary/apod?api_key=Ad5FiPZWPYc2xB330H839WyrrNP3f349TJbsBBq4&date=2023-03-19";
    @Override
    public String getBotUsername() {
        return null;
    }

    @Override
    public String getBotToken() {
        return null;
    }

    @Override
    public void onUpdateReceived(Update update) {

    }
}
