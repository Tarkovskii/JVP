package tutorial;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import tutorial.command.ListenerCommands;

public class Main {
    public static void main(String[] args) throws TelegramApiException {

        Bot bot = new Bot(/**for name and token*/);
        bot.connectionBot();



    }
}

