import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
public class Bot extends TelegramLongPollingBot
{
    @Override
    public String getBotToken()
    {
        return "6227701499:AAGjoAFDjo-3fpsSh26VVyWZ06x7K0ZucYo";
    }
    @Override
    public void onUpdateReceived(Update update)
    {
        // fall out boys CQACAgIAAxkBAAMOZGPNebI_NJYgfg-On9edujpd5DkAAp41AALBwiBLgiisnigyJG0vBA - получил заранее узнав ID песни через бота
        SendAudio sendAudio = new SendAudio();
        sendAudio.setChatId(update.getMessage().getChatId().toString());
        sendAudio.setAudio(new InputFile("CQACAgIAAxkBAAMOZGPNebI_NJYgfg-On9edujpd5DkAAp41AALBwiBLgiisnigyJG0vBA"));
        sendAudio.setCaption("Этот файл будет отправлен три раза");
        try
        {
            for (int i = 0; i < 3; i++)
            {
                execute(sendAudio);
            }
        }
        catch (TelegramApiException e)
        {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String getBotUsername()
    {
        return "HomeTask60_bot";
    }
}
