package halitov.netlogy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseNASA {
    private final String copyright;
    private final  String date;
    private final String explanation;
    private final String hdurl;
    private final String media_type;
    private final String service_version;
    private final String title;
    private final String url;

    public ResponseNASA(@JsonProperty("copyright") String copyright,
                        @JsonProperty("date") String date,
                        @JsonProperty("explanation") String explanation,
                        @JsonProperty("hdurl") String hdurl,
                        @JsonProperty("media_type") String media_type,
                        @JsonProperty("service_version") String service_version,
                        @JsonProperty("title") String title,
                        @JsonProperty("url") String url) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.media_type = media_type;
        this.service_version = service_version;
        this.title = title;
        this.url = url;
    }

//    public String getCopyright() {
//        return copyright;
//    }

//    public String getDate() {
//        return date;
//    }

//    public String getExplanation() {
//        return explanation;
//    }

//    public String getHdurl() {
//        return hdurl;
//    }

//    public String getMedia_type() {
//        return media_type;
//    }

//    public String getService_version() {
//        return service_version;
//    }

//    public String getTitle() {
//        return title;
//    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "ResponseNASA\n{ " +
                "\n copyright='" + copyright + '\'' +
                ",\n date='" + date + '\'' +
                ",\n explanation='" + explanation + '\'' +
                ",\n hdurl='" + hdurl + '\'' +
                ",\n media_type='" + media_type + '\'' +
                ",\n service_version='" + service_version + '\'' +
                ",\n title='" + title + '\'' +
                ",\n url='" + url + '\'' +
                "\n}";
    }
}
