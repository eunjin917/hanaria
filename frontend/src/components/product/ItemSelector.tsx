import { useEffect, useState } from "react";
import ProductType from "../../types/ProductType";
import GroupType from "../../types/GroupType";
import { HStack, VStack } from "../common/Stack";
import ProductSelector from "./ProductSelector";
import { Swiper, SwiperSlide } from "swiper/react";

// Import Swiper styles
import "swiper/css";
import "swiper/css/pagination";
import {
  demoDessertOptions,
  demoDrinkOptions,
} from "../../types/demos/demoOptions";
import OptionCell from "./OptionCell";
import OptionType from "../../types/OptionType";
import Button from "../common/Button";
import RequestSelecor from "./RequestSelector";
import Title from "../common/Title";
import LocalItemType from "../../types/local/LocalItemType";

interface ItemSelectorProps {
  group: GroupType;
  onClose: () => void;
  onSelect: (localItem: LocalItemType) => void;
}

function ItemSelector({ group, onClose, onSelect }: ItemSelectorProps) {
  const [product, setProduct] = useState<ProductType | null>(null);
  const [count, setCount] = useState<number>(1);
  const [dessertOption, setDessertOption] = useState<OptionType | null>(null);
  const [drinkOption, setDrinkOption] = useState<OptionType | null>(null);
  const [allSelected, setAllSelected] = useState<boolean>(false);
  const [requests, setRequests] = useState<number>(0);

  //총 가격 계산
  const totalPrice =
    ((product?.price ?? 0) +
      (dessertOption?.price ?? 0) +
      (drinkOption?.price ?? 0)) *
    count;

  //상품 수량 업다운
  const countUp = () => setCount((count) => count + 1);
  const countDown = () => {
    if (count > 1)
      setCount((count) => {
        return count - 1;
      });
  };
  useEffect(() => {
    if (product == null) return;
    if (demoDessertOptions.length > 0) setDessertOption(demoDessertOptions[0]);
    if (demoDrinkOptions.length > 0) setDrinkOption(demoDrinkOptions[0]);
  }, [product, demoDessertOptions, demoDrinkOptions]);

  //선택한 상품 초기화
  const clearProduct = () => {
    setProduct(null);
    setCount(1);
    setDessertOption(null);
    setDrinkOption(null);
    setRequests(0);
  };

  // 주문담기
  const confirm = () => {
    const localItemDraft: LocalItemType = {
      price: totalPrice,
      count: count,
      request: requests,
      product: product,
      dessertOption: dessertOption,
      drinkOption: drinkOption,
    };
    onSelect(localItemDraft);
    onClose();
  };

  // 1: 상품 선택
  if (product == null)
    return (
      <VStack>
        <Title>상품 선택</Title>
        <ProductSelector products={group.productList} onSelect={setProduct} />
      </VStack>
    );

  // 2: 상품 수량, 옵션 선택
  if (!allSelected)
    return (
      <VStack>
        <Title>상품 수량 및 옵션 선택</Title>
        <HStack className="items-center">
          <img
            className="bg-white w-36 h-36 object-contain rounded-xl shadowed mb-2"
            src={product.image ?? ""}
          />
          <VStack className="text-start ml-4">
            <span className="w-48 font-bold">{product.name}</span>
            <HStack>
              <button
                className="p-0 w-6 h-6 hover:scale-105 transition-all font-bold leading-none rounded-xl shadowed"
                onClick={countDown}
              >
                -
              </button>
              <span className="font-bold w-10 text-center">{count} 개</span>
              <button
                className="p-0 w-6 h-6 hover:scale-105 transition-all font-bold leading-none rounded-xl shadowed"
                onClick={countUp}
              >
                +
              </button>
            </HStack>
            <span className="font-semibold text-">
              총 {totalPrice.toLocaleString()}원
            </span>
          </VStack>
        </HStack>
        {product.dessertOptionAvailable && (
          <>
            <span className="font-bold">디저트 옵션 선택</span>
            <Swiper
              slidesPerView={4}
              spaceBetween={30}
              className="!w-96 bg-slate-100 rounded-xl"
            >
              {[...demoDessertOptions, ...demoDessertOptions].map((option) => (
                <SwiperSlide>
                  <OptionCell
                    option={option}
                    selected={dessertOption?.id == option.id}
                    onClick={() => setDessertOption(option)}
                  />
                </SwiperSlide>
              ))}
              {/* 한칸 여유 두기 */}
              <SwiperSlide />
            </Swiper>
          </>
        )}
        {product.drinkOptionAvailable && (
          <>
            <span className="font-bold">음료 옵션 선택</span>
            <Swiper
              slidesPerView={4}
              spaceBetween={30}
              className="!w-96  bg-slate-100 rounded-xl"
            >
              {demoDrinkOptions.map((option) => (
                <SwiperSlide>
                  <OptionCell
                    option={option}
                    selected={drinkOption?.id == option.id}
                    onClick={() => setDrinkOption(option)}
                  />
                </SwiperSlide>
              ))}
              {/* 한칸 여유 두기 */}
              <SwiperSlide />
            </Swiper>
          </>
        )}
        <HStack className="justify-center mt-2">
          <Button
            className="bg-red-400 font-bold text-white mr-2"
            onClick={clearProduct}
          >
            뒤로가기
          </Button>
          <Button
            className="bg-blue-400 font-bold text-white"
            onClick={() => {
              setAllSelected(true);
            }}
          >
            선택완료
          </Button>
        </HStack>
      </VStack>
    );

  // 3: 주문 담기 직전 요청사항
  return (
    <VStack>
      <Title>요청사항 선택</Title>
      <RequestSelecor requests={requests} onSelect={setRequests} />
      <HStack className="justify-center mt-4">
        <Button
          className="bg-red-400 font-bold text-white mr-2"
          onClick={() => {
            setAllSelected(false);
          }}
        >
          뒤로가기
        </Button>
        <Button className="bg-blue-400 font-bold text-white" onClick={confirm}>
          주문담기
        </Button>
      </HStack>
    </VStack>
  );
}

export default ItemSelector;
