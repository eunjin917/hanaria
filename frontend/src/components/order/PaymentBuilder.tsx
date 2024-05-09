import { useEffect, useState } from "react";
import { HStack, VStack } from "../common/Stack";
import Title from "../common/Title";
import Button from "../common/Button";
import PaymentCell from "./PaymentCell";

interface PaymentBuilderProps {
  orderId: number;
  orderCode: string;
  totalPrice: number;
  isLumpSum: boolean;
}

function PaymentBuilder({
  orderId,
  orderCode,
  totalPrice,
  isLumpSum,
}: PaymentBuilderProps) {
  const [dutchCount, setDutchCount] = useState<number>(2);
  const [countSelected, setCountSelected] = useState<boolean>(false);
  const [allPaymentDone, setAllPaymentDone] = useState<boolean>(false);
  const [tmpNo, setTmpNo] = useState<number | null>(null);
  const [showTmpNo, setShowTmpNo] = useState<boolean>(false);
  const countDown = () => {
    if (dutchCount > 2) setDutchCount(dutchCount - 1);
  };
  const countUp = () => {
    setDutchCount(dutchCount + 1);
  };
  const getTmpNo = (tmpNo: number | null) => {
    if (tmpNo == null) return;
    setTmpNo(tmpNo);
    setAllPaymentDone(true);
  };
  useEffect(() => {
    if (isLumpSum) {
      setDutchCount(1);
      setCountSelected(true);
    }
  });
  // 1: 사람 수 선택, 일괄결제면 스킵됨
  if (!countSelected)
    return (
      <VStack className="w-96 my-4 items-center">
        <Title>분할결제할 인원을 선택하세요.</Title>
        <HStack className="justify-center items-center leading-none font-bold text-center mb-4">
          <button
            className="rounded shadowed w-4 h-4 bg-white"
            onClick={countDown}
          >
            -
          </button>
          <span className="w-8 text-xl">{dutchCount}</span>
          <button
            className="rounded shadowed w-4 h-4 bg-white"
            onClick={countUp}
          >
            +
          </button>
        </HStack>
        <Button
          className="py-2 font-bold"
          onClick={() => setCountSelected(true)}
        >
          확인
        </Button>
      </VStack>
    );
  // 2: 결제하기, 사람수만큼 분리됨
  if (!showTmpNo)
    return (
      <VStack className="w-96 my-4 items-center">
        <Title>결제 진행 중입니다.</Title>

        <Title>주문코드: {orderCode}</Title>
        {Array.from({ length: dutchCount }, (_, index) => index).map(
          (index) => (
            <PaymentCell
              key={index}
              index={index + 1}
              price={Math.floor(totalPrice / dutchCount)}
              onAllPaymentDone={getTmpNo}
            />
          )
        )}
        {allPaymentDone ? (
          <Button
            className="mt-6 font-bold bg-blue-50 text-blue-400"
            onClick={() => setShowTmpNo(true)}
          >
            결제 완료
          </Button>
        ) : (
          <Button className="mt-6 font-bold bg-blue-50 text-gray-400 hover:scale-100 cursor-default">
            결제 완료
          </Button>
        )}
      </VStack>
    );
  // 3: 모든 결제 완료됨
  if (showTmpNo)
    return (
      <VStack className="w-96 my-4 items-center">
        <Title>결제가 완료되었습니다.</Title>
        <Title>상품이 준비될 때까지 기다려 주세요.</Title>
        <Title>주문코드: {orderCode}</Title>
        <br />
        <Title>주문번호:</Title>
        <span className="font-bold text-3xl">{tmpNo}</span>
      </VStack>
    );
}
export default PaymentBuilder;
