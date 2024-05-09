import { HStack, VStack } from "../common/Stack";
import { Swiper, SwiperSlide } from "swiper/react";
import SwiperCore from "swiper"; // 타입지정을 위해 필요하다.
// Import Swiper styles
import "swiper/css";
import "swiper/css/pagination";
import "swiper/css/navigation";
// import required modules
import { Controller } from "swiper/modules";
import { useState } from "react";
import OrderPage from "./OrderPage";
import ProgressSteps, { Step } from "./ProgressSteps";
import OrderType from "../../types/OrderType";
import LocalItemType from "../../types/local/LocalItemType";
import Title from "../common/Title";
import ReceiptLine from "./ReceiptLine";
import Divider from "./Divider";
import Button from "../common/Button";

interface OrderBuilderProps {
  cartItems: LocalItemType[];
  totalPrice: number;
  onClose: () => void;
  onLogin: () => void;
  currentPoint: number;
  earningPoint: number;
  onOrderDone: (order: OrderType) => void;
}

function OrderBuilder({
  cartItems,
  totalPrice,
  onClose,
  onLogin,
  currentPoint,
  earningPoint,
  onOrderDone,
}: OrderBuilderProps) {
  const [swiper, setSwiper] = useState<SwiperCore>();
  const [isForHere, setIsForHere] = useState<boolean | null>(null);
  const [isEarningPoint, setIsEarningPoint] = useState<boolean | null>(null);
  const [isLumpSum, setIsLumpSum] = useState<boolean | null>(null);
  const [currentStep, setCurrentStep] = useState(1);
  const [steps, setSteps] = useState<Step[]>([
    { label: "주문방법", step: 1 },
    { label: "적립여부", step: 2 },
    { label: "결제방법", step: 3 },
    { label: "주문확인", step: 4 },
  ]);

  // 방법 선택하자마자 화면 넘어가도록 하는거
  // useEffect(() => {
  //   if (isForHere != null) nextStep();
  // }, [steps]);

  const nextStep = () => {
    setCurrentStep((step) => step + 1);
    swiper?.slideTo(currentStep);
  };
  const selectStep = (step: number) => {
    setCurrentStep(step - 1);
    swiper?.slideTo(step - 1);
  };
  const chooseForHere = (nextIsForHere: boolean, label: string) => {
    setIsForHere(nextIsForHere);
    const nextSteps = [...steps];
    nextSteps[0].label = label;
    setSteps(nextSteps);
  };
  const chooseEarningPoint = (nextIsEarningPoint: boolean, label: string) => {
    setIsEarningPoint(nextIsEarningPoint);
    const nextSteps = [...steps];
    nextSteps[1].label = label;
    setSteps(nextSteps);
  };
  const chooseLumpSum = (nextIsLumpSum: boolean, label: string) => {
    setIsLumpSum(nextIsLumpSum);
    const nextSteps = [...steps];
    nextSteps[2].label = label;
    setSteps(nextSteps);
  };
  const completeOrder = () => {
    const order: OrderType = {
      price: totalPrice,
      isForHere: isForHere!,
      memberId: 0,
      items: cartItems.map((item) => ({
        count: item.count,
        request: item.request,
        productId: item.product.id,
        dessertOptionId: item.dessertOption?.id ?? null,
        drinkOptionId: item.drinkOption?.id ?? null,
      })),
    };
    onOrderDone(order);
  };
  return (
    <HStack>
      <Swiper
        slidesPerView={1}
        autoHeight={true}
        spaceBetween={30}
        modules={[Controller]}
        onSwiper={setSwiper}
        controller={{ control: swiper }}
        direction={"vertical"}
        onSlideChange={(swiper) => {
          setCurrentStep(swiper.realIndex + 1);
        }}
      >
        <SwiperSlide className="!h-fit">
          <OrderPage
            title={"주문방법"}
            textLeft={"매장식사"}
            textRight={"포장주문"}
            isLeftSelected={isForHere}
            onSelect={chooseForHere}
            onNext={nextStep}
          />
        </SwiperSlide>
        {isForHere != null && (
          <SwiperSlide className="!h-fit">
            <OrderPage
              title={"적립여부"}
              textLeft={"적립하기"}
              textRight={"적립안함"}
              isLeftSelected={isEarningPoint}
              onSelect={chooseEarningPoint}
              onNext={nextStep}
            />
          </SwiperSlide>
        )}
        {isEarningPoint != null && (
          <SwiperSlide className="!h-fit">
            <OrderPage
              title={"결제방법"}
              textLeft={"일괄결제"}
              textRight={"분할결제"}
              isLeftSelected={isLumpSum}
              onSelect={chooseLumpSum}
              onNext={nextStep}
            />
          </SwiperSlide>
        )}
        {isLumpSum != null && (
          <SwiperSlide className="flex flex-col my-2 items-center">
            <Title>주문 정보를 확인하세요.</Title>
            <VStack className="bg-slate-100 w-full h-60 overflow-y-scroll mx-4 mr-8 mt-2 mb-6 p-4 rounded-xl">
              <ReceiptLine title={"주문방법"} value={steps[0].label} />
              <Divider />
              <ReceiptLine title={"적립여부"} value={steps[1].label} />
              <Divider />
              {steps[1].label === "적립하기" && (
                <>
                  {" "}
                  <ReceiptLine
                    title={"ㄴ 보유 적립금"}
                    value={currentPoint.toLocaleString() + "원"}
                  />
                  <Divider />
                  <ReceiptLine
                    title={"ㄴ 추가 적립금"}
                    value={"+ " + earningPoint.toLocaleString() + "원"}
                  />
                  <Divider />
                </>
              )}
              <ReceiptLine title={"결제방법"} value={steps[2].label} />
              <Divider />
              <div className="mb-8" />
              {cartItems.map((item, index) => (
                <>
                  <ReceiptLine
                    key={index}
                    title={`${item.product.name} ${item.count > 1 ? "* " + item.count : ""}`}
                    value={item.price.toLocaleString() + "원"}
                  />
                  <Divider />
                  {item.dessertOption != null && (
                    <>
                      <ReceiptLine
                        key={index}
                        title={`ㄴ ${item.dessertOption.productName}`}
                        value={`+ ${(item.drinkOption.price * item.count).toLocaleString()}원`}
                      />
                      <Divider />
                    </>
                  )}
                  {item.drinkOption != null && (
                    <>
                      <ReceiptLine
                        key={index}
                        title={`ㄴ ${item.drinkOption.productName}`}
                        value={`+ ${(item.drinkOption.price * item.count).toLocaleString()}원`}
                      />
                      <Divider />
                    </>
                  )}
                </>
              ))}
            </VStack>
            <HStack>
              <Button
                className="mx-1 !w-48 bg-yellow-200 font-bold text-lg"
                onClick={onClose}
              >
                추가주문
              </Button>
              <Button
                className="mx-1 !w-48 bg-yellow-200 font-bold text-lg"
                onClick={completeOrder}
              >
                결제하기 ({totalPrice.toLocaleString()}원)
              </Button>
            </HStack>
          </SwiperSlide>
        )}
      </Swiper>
      <ProgressSteps step={currentStep} steps={steps} onSelect={selectStep} />
    </HStack>
  );
}

export default OrderBuilder;
