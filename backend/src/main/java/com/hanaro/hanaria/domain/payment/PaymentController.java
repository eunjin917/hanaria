package com.hanaro.hanaria.domain.payment;

import com.hanaro.hanaria.domain.order.OrderService;
import com.hanaro.hanaria.dto.order.OrderFindAllResponseDto;
import com.hanaro.hanaria.dto.payment.PaymentFindAllResponseDto;
import com.hanaro.hanaria.dto.payment.PaymentFindByIdResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final OrderService orderService;

    @GetMapping("/payments")
    public String adminPayments(Model model
    ) {
        List<PaymentFindAllResponseDto> paymentFindAllResponseDtoList = paymentService.findAll();
        List<OrderFindAllResponseDto> orderFindAllResponseDtoList = orderService.findAll();
        model.addAttribute("list", paymentFindAllResponseDtoList);
        model.addAttribute("orders", orderFindAllResponseDtoList);
        return "/pages/payment/payments";
    }

    @GetMapping("/payment/{id}")
    public String adminPaymentDetail(Model model, @PathVariable(name = "id") Long id) {
        PaymentFindByIdResponseDto dto = paymentService.findById(id);
        model.addAttribute("payment", dto);
        return "/pages/payment/paymentDetail";
    }

}
