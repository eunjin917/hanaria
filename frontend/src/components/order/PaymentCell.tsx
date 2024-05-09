import { useState } from "react";
import { HStack, VStack } from "../common/Stack";
import Button from "../common/Button";
import Modal from "../common/Modal";
import Title from "../common/Title";

interface PaymentCellProps {
  price: number;
  index: number;
  onAllPaymentDone: (tmpNo: number | null) => void;
}

function PaymentCell({ price, index, onAllPaymentDone }: PaymentCellProps) {
  const [approvalNo, setApprovalNo] = useState<number | null>(null);
  const [paying, setPaying] = useState<number>(0);
  const pay = () => {
    setPaying(1);
  };
  // 1: 결제 대기중
  if (approvalNo == null)
    return (
      <>
        {paying > 0 && (
          <Modal onClose={() => {}} closeButton={false}>
            {(() => {
              switch (paying) {
                case 1:
                  return (
                    <VStack className="h-72 justify-between">
                      <Title>카드를 단말기에 넣어주세요.</Title>
                      <img
                        src="https://static.thenounproject.com/png/485013-200.png"
                        onClick={() => setPaying(2)}
                      />
                    </VStack>
                  );
                case 2:
                  return (
                    <VStack className="h-72 justify-between">
                      <Title>결제 진행 중입니다.</Title>
                      <Title>카드를 빼지 말아주세요.</Title>
                      <img
                        src="https://static.thenounproject.com/png/485013-200.png"
                        onClick={() => {
                          setApprovalNo(0);
                          onAllPaymentDone(304);
                          setPaying(0);
                        }}
                      />
                    </VStack>
                  );
              }
            })()}
          </Modal>
        )}
        <HStack className="items-center w-full p-4 rounded-xl bg-slate-100 font-bold justify-between">
          <HStack className="items-center gap-4">
            <span className="text-gray-500">#{index}</span>
            {price.toLocaleString()}원
          </HStack>
          <Button className="font-bold bg-white text-blue-400" onClick={pay}>
            결제하기
          </Button>
        </HStack>
      </>
    );
  // 2: 결제 완료
  return (
    <HStack className="items-center w-full p-4 rounded-xl bg-slate-100 font-bold justify-between">
      <HStack className="items-center gap-4">
        <span className="text-gray-500">#{index}</span>
        {price.toLocaleString()}원
        <span className="text-gray-500">승인번호: {approvalNo}</span>
      </HStack>
      <Button
        className="font-bold text-blue-50 bg-blue-400 hover:scale-100"
        disabled
      >
        결제완료
      </Button>
    </HStack>
  );
}
export default PaymentCell;
