package com.hanaro.hanaria.domain.request;

import com.hanaro.hanaria.domain.group.GroupCategory;
import com.hanaro.hanaria.domain.group.GroupService;
import com.hanaro.hanaria.dto.group.GroupFindAllResponseDto;
import com.hanaro.hanaria.dto.order.OrderFindAllResponseDto;
import com.hanaro.hanaria.dto.payment.PaymentFindAllResponseDto;
import com.hanaro.hanaria.dto.request.RequestFindAllResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RequestController {
    private final RequestService requestService;
    private final GroupService groupService;

    @GetMapping("/requests")
    public String adminRequests(Model model
    ) {
        List<RequestFindAllResponseDto> requestFindAllResponseDtoList = requestService.findAll();
        List<GroupFindAllResponseDto> groupFindAllResponseDtoList = groupService.findAll();
        model.addAttribute("list", requestFindAllResponseDtoList);
        model.addAttribute("groups", groupFindAllResponseDtoList);
        return "/pages/request/requests";
    }
}
