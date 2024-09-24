package tutorial.command;


import org.checkerframework.checker.units.qual.C;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import tutorial.Bot;

import javax.xml.transform.Source;
import java.net.Socket;

public class ListenerCommands {
    private Bot bot;

    private Commands commands;
    public ResponseOnCommands response = new ResponseOnCommands();

    public ListenerCommands(Bot bot) {
        this.bot = bot;
    }


    public void inputUpdate(Update update) {

        System.out.println("Ya from listener");
        switch (commandsType(parserCommand(update))) {
            case START:
                try {
                    bot.execute(response.responseStart(forChatId(update),update));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
                break;
            case ADD_VACATION:
                System.out.println("I am in bloc create vacarton");
                try {
                    bot.execute(response.responseForAddDate(update, forChatIdLong(update), parserCommand(update)));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
                break;
            case ADD_YEAR:
                System.out.println("I am send year");
                try {
                    bot.execute(response.responseYear(update, forChatIdLong(update), parserCommand(update)));
                    System.out.println(parserCommand(update));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
                break;
            case ADD_MONTH:
                System.out.println("I am send month");
                try {
                    bot.execute(response.responseMonth(update, forChatIdLong(update), parserCommand(update)));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
                break;
            case ADD_DAY:
                System.out.println("I am send year");
                try {
                    bot.execute(response.responseDay(update, forChatIdLong(update), parserCommand(update)));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
                break;
            case SHOW_THIS_VACATION:
                System.out.println("I am show new vacation");
                try {
                    bot.execute(response.responseNewVacation(update, forChatIdLong(update)));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
                break;
            case SAVE_VACATION:
                System.out.println("I am save vacation in db");
                try {
                    bot.execute(response.saveVacationInDB(update,forChatIdLong(update)));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
                break;
            case SHOW_VACATIONS:
                System.out.println("I am show all vacations for user");
                try {
                    bot.execute(response.responseShowAllVacationsForUser(update, forChatIdLong(update)));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }


            default:
                System.out.println("WTF");
        }
    }


    private String forChatId(Update update) {
        Long id = update.getMessage().getFrom().getId();
        return String.valueOf(id);
    }

    private Long forChatIdLong(Update update) {

        if (update.hasMessage()) {
            Long id = update.getMessage().getFrom().getId();
            System.out.println(" for chat id long - " + id);
            return id;
        }
        if (update.hasCallbackQuery()) {
            Long id = Long.valueOf(update.getCallbackQuery().getFrom().getId());
            System.out.println(" for chat id long - " + id);
            return id;
        }
        return -1L;
    }

    private String parserCommand(Update update) {
        String result = "";
        if (update.hasMessage()) {
            result = update.getMessage().getText();
            System.out.println("I am parsing message " + update.getMessage().getText());
            return result.toLowerCase().trim();
        }
        if (update.hasCallbackQuery()) {
            result = update.getCallbackQuery().getData();
            System.out.println("I am return data " + result);


            return result.toLowerCase().trim();
        }
        return "I iam empty";
    }

    private Commands commandsType(String parsedUpdate) {
        if (parsedUpdate.equals("/start")) return Commands.START;
        if (parsedUpdate.equals("add vacation")) return Commands.ADD_VACATION;
        if (parsedUpdate.equals("date start") || parsedUpdate.substring(0, 1).equals("d") && parsedUpdate.substring(3).equals("-"))
            return Commands.ADD_YEAR;
        if (parsedUpdate.substring(0, 1).equals("y") && parsedUpdate.substring(5).equals("-"))
            return Commands.ADD_MONTH;
        if (parsedUpdate.substring(0, 1).equals("m") && parsedUpdate.substring(3).equals("-")) return Commands.ADD_DAY;
        if (parsedUpdate.equals("show vacation")) return Commands.SHOW_THIS_VACATION;
        if(parsedUpdate.equals("save vacation")) return Commands.SAVE_VACATION;
        if(parsedUpdate.equals("my vacations")) return Commands.SHOW_VACATIONS;


        return Commands.NONE;
    }


}
