import { HStack, VStack } from "../components/common/Stack";

interface MainProps {
  onClick: () => void;
}

function Main({ onClick }: MainProps) {
  return (
    <VStack
      className="w-screen h-screen items-center justify-center"
      onClick={onClick}
    >
      <HStack className="absolute top-0 left-0">
        <div className="w-32 h-32 scale-125">
          <img src="https://cdn.vectorstock.com/i/500p/89/24/round-flag-south-korea-button-icon-glossy-vector-33378924.avif" />
        </div>
        <div className="w-32 h-32 scale-125">
          <img src="https://cdn.vectorstock.com/i/500p/89/46/round-flag-united-states-button-icon-glossy-vector-33378946.avif" />
        </div>
      </HStack>
      <span className="text-5xl font-bold text-center">
        여기에서
        <br /> 주문하세요!
      </span>
      <img src="https://img.lotteeatz.com/assets/images/common/comm_img_brand_lotteria.png/dims/resize/x191.52/optimize" />
    </VStack>
  );
}
export default Main;
