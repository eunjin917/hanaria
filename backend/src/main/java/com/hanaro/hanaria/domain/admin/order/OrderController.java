package com.hanaro.hanaria.domain.admin.order;

import com.hanaro.hanaria.domain.admin.payment.PaymentService;
import com.hanaro.hanaria.domain.admin.member.MemberService;
import com.hanaro.hanaria.dto.admin.order.OrderFindAllResponseDto;
import com.hanaro.hanaria.dto.admin.order.OrderFindByIdResponseDto;
import com.hanaro.hanaria.dto.admin.member.MemberFindAllResponseDto;
import com.hanaro.hanaria.dto.admin.payment.PaymentFindByOrderIdResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/admin")
@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;
    private final PaymentService paymentService;

    @GetMapping("/orders")
    public String adminMembers(Model model
    ) {
        List<OrderFindAllResponseDto> orderFindAllResponseDtoList = orderService.findAll();
        List<MemberFindAllResponseDto> memberFindAllResponseDtoList = memberService.findAll();
        model.addAttribute("list", orderFindAllResponseDtoList);
        model.addAttribute("members", memberFindAllResponseDtoList);
        model.addAttribute("methods", OrderMethod.values());
        model.addAttribute("statuses", OrderStatus.values());
        return "/pages/order/orders";
    }

    @GetMapping("/order/{id}")
    public String adminMemberDetail(Model model, @PathVariable(name = "id") Long id) {
        OrderFindByIdResponseDto dto = orderService.findById(id);
        List<MemberFindAllResponseDto> memberFindAllResponseDtoList = memberService.findAll();
        List<PaymentFindByOrderIdResponseDto> paymentFindByOrderIdResponseDtoList = paymentService.findByOrderId(id);
        model.addAttribute("order", dto);
        model.addAttribute("payments", paymentFindByOrderIdResponseDtoList);
        model.addAttribute("members", memberFindAllResponseDtoList);
        model.addAttribute("methods", OrderMethod.values());
        model.addAttribute("statuses", OrderStatus.values());
        return "/pages/order/orderDetail";
    }

}
