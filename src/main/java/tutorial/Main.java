package tutorial;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        String bot_name = System.getenv("BOT_NAME");
        String token = System.getenv("BOT_TOKEN");
        Bot bot = new Bot(bot_name, token);
        bot.connectionBot();
    }
}

