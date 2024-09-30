package tutorial.keyboards;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SenderKeyboard {

    public List<List<InlineKeyboardButton>> sendButtonStartData(){
        List<List<InlineKeyboardButton>> buttonYearList = new ArrayList<>();
        List<InlineKeyboardButton> rowInLineYear = new ArrayList<>();
        InlineKeyboardButton buttonYear = new InlineKeyboardButton();
        buttonYear.setCallbackData("Date start");
        buttonYear.setText("Press the button to enter dates");

        rowInLineYear.add(buttonYear);
        buttonYearList.add(rowInLineYear);

        return buttonYearList;
    }

    public List<List<InlineKeyboardButton>> sendButtonShowVacation(){
        List<List<InlineKeyboardButton>> buttonMonthList = new ArrayList<>();
        List<InlineKeyboardButton> rowInLineMonth = new ArrayList<>();
        InlineKeyboardButton buttonMonth = new InlineKeyboardButton();
        buttonMonth.setCallbackData("Show vacation");
        buttonMonth.setText("Show vacation");

        rowInLineMonth.add(buttonMonth);
        buttonMonthList.add(rowInLineMonth);

        return buttonMonthList;
    }

    public List<List<InlineKeyboardButton>> sendSaneVacationInDB(){
        List<List<InlineKeyboardButton>> buttonDayList = new ArrayList<>();
        List<InlineKeyboardButton> rowInLineDay = new ArrayList<>();
        InlineKeyboardButton buttonDay = new InlineKeyboardButton();
        buttonDay.setCallbackData("Save vacation");
        buttonDay.setText("Save vacation");

        rowInLineDay.add(buttonDay);
        buttonDayList.add(rowInLineDay);

        return buttonDayList;
    }

    public List<List<InlineKeyboardButton>> sendKeyboardWitchYear() {
//        SendMessage sm = new SendMessage();
//        sm.setChatId(String.valueOf(chatId));
//        sm.setText("Choose year");

        //InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();

        List<InlineKeyboardButton> rowInLine1 = new ArrayList<>();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("2024");
        inlineKeyboardButton1.setCallbackData("Y2024-");

        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText("2025");
        inlineKeyboardButton2.setCallbackData("Y2025-");

        rowInLine1.add(inlineKeyboardButton1);
        rowInLine1.add(inlineKeyboardButton2);
        rowsInLine.add(rowInLine1);
//        keyboardMarkup.setKeyboard(rowsInLine);
//        sm.setReplyMarkup(keyboardMarkup);

        return rowsInLine;
    }

    public List<List<InlineKeyboardButton>> keyboardWitchMonth() {

//        SendMessage sm = new SendMessage();
//        sm.setChatId(String.valueOf(chatId));
//        sm.setText("Choose month");
//        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();


        List<InlineKeyboardButton> rowInLine1 = new ArrayList<>();


        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Январь");
        inlineKeyboardButton1.setCallbackData("M01-");

        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText("Февраль");
        inlineKeyboardButton2.setCallbackData("M02-");

        rowInLine1.add(inlineKeyboardButton1);
        rowInLine1.add(inlineKeyboardButton2);


        List<InlineKeyboardButton> rowInLine2 = new ArrayList<>();

        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton3.setText("Март");
        inlineKeyboardButton3.setCallbackData("M03-");

        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        inlineKeyboardButton4.setText("Апрель");
        inlineKeyboardButton4.setCallbackData("M04-");

        rowInLine2.add(inlineKeyboardButton3);
        rowInLine2.add(inlineKeyboardButton4);

        List<InlineKeyboardButton> rowInLine3 = new ArrayList<>();

        InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();
        inlineKeyboardButton5.setText("Май");
        inlineKeyboardButton5.setCallbackData("M05-");

        InlineKeyboardButton inlineKeyboardButton6 = new InlineKeyboardButton();
        inlineKeyboardButton6.setText("Июнь");
        inlineKeyboardButton6.setCallbackData("M06-");

        rowInLine3.add(inlineKeyboardButton5);
        rowInLine3.add(inlineKeyboardButton6);

        List<InlineKeyboardButton> rowInLine4 = new ArrayList<>();


        InlineKeyboardButton inlineKeyboardButton7 = new InlineKeyboardButton();
        inlineKeyboardButton7.setText("Июль");
        inlineKeyboardButton7.setCallbackData("M07-");

        InlineKeyboardButton inlineKeyboardButton8 = new InlineKeyboardButton();
        inlineKeyboardButton8.setText("Август");
        inlineKeyboardButton8.setCallbackData("M08-");

        rowInLine4.add(inlineKeyboardButton7);
        rowInLine4.add(inlineKeyboardButton8);

        List<InlineKeyboardButton> rowInLine5 = new ArrayList<>();


        InlineKeyboardButton inlineKeyboardButton9 = new InlineKeyboardButton();
        inlineKeyboardButton9.setText("Сентябрь");
        inlineKeyboardButton9.setCallbackData("M09-");

        InlineKeyboardButton inlineKeyboardButton10 = new InlineKeyboardButton();
        inlineKeyboardButton10.setText("Октябрь");
        inlineKeyboardButton10.setCallbackData("M10-");

        rowInLine5.add(inlineKeyboardButton9);
        rowInLine5.add(inlineKeyboardButton10);

        List<InlineKeyboardButton> rowInLine6 = new ArrayList<>();


        InlineKeyboardButton inlineKeyboardButton11 = new InlineKeyboardButton();
        inlineKeyboardButton11.setText("Ноябрь");
        inlineKeyboardButton11.setCallbackData("M11-");

        InlineKeyboardButton inlineKeyboardButton12 = new InlineKeyboardButton();
        inlineKeyboardButton12.setText("Декабрь");
        inlineKeyboardButton12.setCallbackData("M12-");

        rowInLine6.add(inlineKeyboardButton11);
        rowInLine6.add(inlineKeyboardButton12);


        rowsInLine.add(rowInLine1);
        rowsInLine.add(rowInLine2);
        rowsInLine.add(rowInLine3);
        rowsInLine.add(rowInLine4);
        rowsInLine.add(rowInLine5);
        rowsInLine.add(rowInLine6);


        //keyboardMarkup.setKeyboard(rowsInLine);


        //sm.setReplyMarkup(keyboardMarkup);

        return rowsInLine;

    }

    public List<List<InlineKeyboardButton>> keyboardWitchDays() {
        Calendar calendar = Calendar.getInstance();

        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();

        List<InlineKeyboardButton> rowInLain1 = new ArrayList<>();
        List<InlineKeyboardButton> rowInLain2 = new ArrayList<>();
        List<InlineKeyboardButton> rowInLain3 = new ArrayList<>();
        List<InlineKeyboardButton> rowInLain4 = new ArrayList<>();
        int counterDay = 0;

        for (int i = 0; i < 14; i++) {
            if (i < 4) {
                InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();

                calendar.add(Calendar.DAY_OF_MONTH, i);
                String[] splDate = calendar.getTime().toString().split(" ");

                inlineKeyboardButton.setText(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)) + " \n " + splDate[1]);
                inlineKeyboardButton.setCallbackData(String.valueOf("D" + calendar.get(Calendar.DAY_OF_MONTH)+"-"));

                //System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
                rowInLain1.add(inlineKeyboardButton);
                calendar = Calendar.getInstance();
                counterDay++;
            }
            if (i >= 4 && i < 8) {
                InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();

                calendar.add(Calendar.DAY_OF_MONTH, i);
                String[] splDate = calendar.getTime().toString().split(" ");

                inlineKeyboardButton.setText(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)) + " \n " + splDate[1]);
                inlineKeyboardButton.setCallbackData(String.valueOf("D"+calendar.get(Calendar.DAY_OF_MONTH)+"-"));

                //System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
                rowInLain2.add(inlineKeyboardButton);
                calendar = Calendar.getInstance();
                counterDay++;
            }
            if (i >= 8 && i < 12) {
                InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();

                calendar.add(Calendar.DAY_OF_MONTH, i);
                String[] splDate = calendar.getTime().toString().split(" ");

                inlineKeyboardButton.setText(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)) + " \n " + splDate[1]);
                inlineKeyboardButton.setCallbackData(String.valueOf("D"+calendar.get(Calendar.DAY_OF_MONTH)+"-"));

                //System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
                rowInLain3.add(inlineKeyboardButton);
                calendar = Calendar.getInstance();
                counterDay++;
            }
            if (i > 11) {
                InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();

                calendar.add(Calendar.DAY_OF_MONTH, i);
                String[] splDate = calendar.getTime().toString().split(" ");

                inlineKeyboardButton.setText(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)) + " \n " + splDate[1]);
                inlineKeyboardButton.setCallbackData(String.valueOf("D"+calendar.get(Calendar.DAY_OF_MONTH)+"-"));

                //System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
                rowInLain4.add(inlineKeyboardButton);
                calendar = Calendar.getInstance();
                counterDay++;
            }
        }
        rowsInLine.add(rowInLain1);
        rowsInLine.add(rowInLain2);
        rowsInLine.add(rowInLain3);
        rowsInLine.add(rowInLain4);

        return rowsInLine;

    }

    public ReplyKeyboardMarkup sendMenu(){

        KeyboardRow kbr = new KeyboardRow();
        kbr.add("My vacations");
        

        KeyboardRow kbr1 = new KeyboardRow();
        kbr1.add("Add vacation");


        List<KeyboardRow> lkbr = new ArrayList<>();
        lkbr.add(kbr);
        lkbr.add(kbr1);


        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setInputFieldPlaceholder("Для твоих букв");
        replyKeyboardMarkup.setKeyboard(lkbr);


        return replyKeyboardMarkup;
    }




}
