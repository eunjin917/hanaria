import { HStack } from "../common/Stack";

interface ReceiptLineProps {
  title: string;
  value: string;
}
function ReceiptLine({ title, value }: ReceiptLineProps) {
  return (
    <HStack className="w-full justify-between font-bold">
      <span>{title}</span>
      <span>{value}</span>
    </HStack>
  );
}
export default ReceiptLine;
