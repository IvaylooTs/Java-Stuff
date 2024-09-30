package zadachi;

public class Invitation {
    public String invite(String name, String event, String date, String time, String address, String author) {
        String inv = " Г-н/г-жо, {name}\r\n Имаме удоволствието да Ви поканим на {event}, което ще се състои на {date} от {time} на адрес {address}\r\n С уважение: {author}";

        inv = inv.replace("{name}", name)
                .replace("{event}", event)
                .replace("{date}", date)
                .replace("{time}", time)
                .replace("{address}", address)
                .replace("{author}", author);

        return inv;
    }
}
