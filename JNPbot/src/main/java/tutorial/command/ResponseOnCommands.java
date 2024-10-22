package tutorial.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import tutorial.keyboards.SenderKeyboard;
import tutorial.controller.VacationController;
import tutorial.model.User;
import tutorial.model.UserVacationView;
import tutorial.model.Vacation;
import tutorial.repo.CacheRepo;

public class ResponseOnCommands {

    SenderKeyboard senderKeyboard = new SenderKeyboard();
    CacheRepo cacheRepo = new CacheRepo();


    public SendMessage responseStart(String forChatId, Update update) throws TelegramApiException {
        Long userId = update.getMessage().getFrom().getId();
        String userName = update.getMessage().getFrom().getUserName();
        User user = new User(userId, userName);
        cacheRepo.saveUserInDB(user);
        cacheRepo.add(user);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(forChatId));
        message.setText("Чем займёмся?");
        message.setReplyMarkup(senderKeyboard.sendMenu());
        return message;
    }

    public SendMessage responseForAddDate(Update update, Long forChatId, String text) {
        if (update.hasMessage() && cacheRepo.personIsExist(forChatId)) {
            System.out.println("I am block responce button chose");
            Long userId = update.getMessage().getFrom().getId();
            String userName = update.getMessage().getFrom().getUserName();
            User user = new User(userId, userName);
            cacheRepo.saveUserInDB(user);
            cacheRepo.add(user);

            System.out.println(cacheRepo.findUserByID(forChatId));

            return SendMessage.builder()
                    .text("Push")
                    .chatId(String.valueOf(forChatId))
                    .replyMarkup(InlineKeyboardMarkup
                            .builder()
                            .keyboard(senderKeyboard.sendButtonStartData()).build())
                    .build();
        }
        return SendMessage.builder()
                .text("What?")
                .chatId(String.valueOf(forChatId))
                .build();
    }

    public synchronized EditMessageReplyMarkup responseYear(Update update, Long forChatId, String text) {

        if (update.hasCallbackQuery() && cacheRepo.personIsExist(forChatId) && !cacheRepo.getBufferPersonByID(forChatId).isValidEndVac() && (text.substring(0, 1).equals("d") && text.substring(3).equals("-"))) {
            System.out.println("I am block responce year");
            System.out.println(cacheRepo.findUserByID(forChatId));
            cacheRepo.setDateBufferPersonByID(forChatId, text.substring(1, 3));
            //System.out.println("Year message id" + update.getMessage().getMessageId());
            if (cacheRepo.getBufferPersonByID(forChatId).isValidEndVac()) {
                return EditMessageReplyMarkup.builder()
                        .chatId(String.valueOf(forChatId))
                        .messageId(update.getCallbackQuery().getMessage().getMessageId())
                        .replyMarkup(InlineKeyboardMarkup.builder().keyboard(senderKeyboard.sendButtonShowVacation()).build())
                        .build();
            }

            return EditMessageReplyMarkup.builder()
                    .chatId(String.valueOf(forChatId))
                    .messageId(update.getCallbackQuery().getMessage().getMessageId())
                    .replyMarkup(InlineKeyboardMarkup.builder().keyboard(senderKeyboard.sendKeyboardWitchYear()).build())
                    .build();
        }

        if (update.hasCallbackQuery() && cacheRepo.personIsExist(forChatId) && !cacheRepo.getBufferPersonByID(forChatId).isValidEndVac()) {
            System.out.println("I am block response year");
            System.out.println(cacheRepo.findUserByID(forChatId));


            return EditMessageReplyMarkup.builder()
                    .chatId(String.valueOf(forChatId))
                    .messageId(update.getCallbackQuery().getMessage().getMessageId())
                    .replyMarkup(InlineKeyboardMarkup.builder().keyboard(senderKeyboard.sendKeyboardWitchYear()).build())
                    .build();
        }

        return new EditMessageReplyMarkup();
    }

    public synchronized EditMessageReplyMarkup responseMonth(Update update, Long forChatId, String text) {
        if (cacheRepo.personIsExist(forChatId)
                && !cacheRepo.getBufferPersonByID(forChatId).isValidEndVac()
                && text.substring(0, 1).equals("y")
                && text.substring(5).equals("-")
        ) {
            cacheRepo.setDateBufferPersonByID(forChatId, text.substring(1, 6));
            System.out.println(cacheRepo.findUserByID(forChatId));
            return EditMessageReplyMarkup.builder()
                    .chatId(String.valueOf(forChatId))
                    .messageId(update.getCallbackQuery().getMessage().getMessageId())
                    .replyMarkup(InlineKeyboardMarkup
                            .builder()
                            .keyboard(senderKeyboard.keyboardWitchMonth()).build())
                    .build();
        }
        return new EditMessageReplyMarkup();
    }

    public synchronized EditMessageReplyMarkup responseDay(Update update, Long forChatId, String text) {
        if (cacheRepo.personIsExist(forChatId) && !cacheRepo.getBufferPersonByID(forChatId).isValidEndVac() && text.substring(0, 1).equals("m") && text.substring(3).equals("-")) {
            cacheRepo.setDateBufferPersonByID(forChatId, text.substring(1, 4));
            System.out.println(cacheRepo.findUserByID(forChatId));
            return EditMessageReplyMarkup.builder()
                    .chatId(String.valueOf(forChatId))
                    .messageId(update.getCallbackQuery().getMessage().getMessageId())
                    .replyMarkup(InlineKeyboardMarkup
                            .builder()
                            .keyboard(senderKeyboard.keyboardWitchDays()).build())
                    .build();
        }

        return new EditMessageReplyMarkup();
    }

    public synchronized SendMessage responseNewVacation(Update update, Long forChatId) {
        String forMessage = "Ты серьёзно?";
        if (cacheRepo.personIsExist(forChatId)) {
            VacationController vacationUser = cacheRepo.getBufferPersonByID(forChatId);
            return SendMessage.builder()
                    .text(formatterForSendVacation(vacationUser))
                    .chatId(forChatId.toString())
                    .replyMarkup(InlineKeyboardMarkup.builder().keyboard(senderKeyboard.sendSaneVacationInDB()).build())
                    .build();
        }

        return SendMessage.builder()
                .text(forMessage)
                .chatId(forChatId.toString())
                .build();
    }

    public SendMessage saveVacationInDB(Update update, Long forChatId) {
        StringBuilder forMessage = new StringBuilder("Отпуск ");
        if (cacheRepo.getBufferPersonByID(forChatId).isValidEndVac() && cacheRepo.personIsExist(forChatId)) {
            cacheRepo.saveVacationInDB(cacheRepo.findUserByID(forChatId));
            //cacheRepo.deleteUserToCache(cacheRepo.findUserByID(forChatId));
            forMessage.append(" Успешно сохранили ");
        }

        return SendMessage.builder()
                .chatId(forChatId.toString())
                .text(forMessage.toString())
                .replyMarkup((senderKeyboard.sendMenu()))
                .build();
    }


    public SendMessage responseShowAllVacationsForUser(Update update, Long forChatId) {
        String forMassage = formatterAllVacationByUser(cacheRepo.loaderVacationsForUserFromDB(forChatId));
        if (forMassage.isEmpty()) {
            forMassage = "Список отпусков пуст";
        }
        return SendMessage.builder()
                .text(forMassage)
                .chatId(forChatId.toString())
                .replyMarkup((senderKeyboard.sendMenu()))
                .build();

    }

    private String formatterForSendVacation(VacationController vc) {
        StringBuilder formatterVc = new StringBuilder();
        if (vc.isValidEndVac() && vc.isValidStartVac()) {
            formatterVc.append("Отпск начнётся: " + vc.getStartVac());
            formatterVc.append("\n");
            formatterVc.append("Отпуск закончится: " + vc.getEndVac());
            return formatterVc.toString();
        }
        return formatterVc.append("Какие-то проблемы с датой, может ты тупой?").toString();
    }

    private String formatterAllVacationByUser(UserVacationView userVacationView) {
        StringBuilder sb = new StringBuilder();
        if (userVacationView == null) {
            return "Vacation not found";
        }
        for (Vacation vac : userVacationView.getVacations()) {
            sb.append("ID отпуска: " + vac.getId().toString());
            sb.append("\n");
            sb.append("Отпск начнётся: " + vac.getStartVacation());
            sb.append("\n");
            sb.append("Отпуск закончится: " + vac.getEndVacation());
            sb.append("\n");
            sb.append("---");
            sb.append("\n");
        }
        return sb.toString();
    }


}
