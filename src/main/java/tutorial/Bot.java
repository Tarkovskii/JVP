package tutorial;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import tutorial.command.ListenerCommands;
import tutorial.keyboards.SenderKeyboard;
import tutorial.repo.Repository;

public class Bot extends TelegramLongPollingBot {
    private String botName;
    private String botToken;
    Repository repo = new Repository();


    SenderKeyboard senderKeyboard = new SenderKeyboard();
    ListenerCommands listenerCommands = new ListenerCommands(this);

    public Bot(String botName,String botToken){
        this.botName = botName;
        this.botToken = botToken;
    }

    @Override
    public String getBotUsername() {
        return getBotName();
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    public String getBotName() {
        return botName;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }


    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }


    @Override
    public void onRegister() {
        super.onRegister();
    }



    @Override
    public void onUpdateReceived(Update update) {
            listenerCommands.inputUpdate(update);
    }

    public void connectionBot() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(this);


    }



}
