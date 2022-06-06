package choiscgvback.cgv.dto;

import choiscgvback.cgv.domain.Member;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
public class MypageDto {
    private final String account;
    private final String name;
    private final int age;
    private final boolean sex;
    private final boolean type;
    private List<TicketDto> tickets = new ArrayList<>();

    public MypageDto(Member member) {
        this.account = member.getAccount();
        this.name = member.getName();
        this.age = member.getAge();
        this.sex = member.isSex();
        this.type = member.isType();
        this.tickets = member.getTickets().stream()
        .map(ticket -> new TicketDto(ticket))
        .collect(Collectors.toList());
    }
}
