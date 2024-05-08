import { useEffect, useReducer, useState } from "react";
import ItemType from "../../types/ItemType";
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

interface ItemSelectorProps {
  group: GroupType;
  onClose: () => void;
  onSelect: (item: ItemType) => void;
}

function ItemSelector({ group, onClose, onSelect }: ItemSelectorProps) {
  const [product, setProduct] = useState<ProductType | null>(null);
  const [count, setCount] = useState<number>(1);
  const [dessertOption, setDessertOption] = useState<OptionType | null>(null);
  const [drinkOption, setDrinkOption] = useState<OptionType | null>(null);
  const totalPrice =
    ((product?.price ?? 0) +
      (dessertOption?.price ?? 0) +
      (drinkOption?.price ?? 0)) *
    count;
  const countUp = () => setCount((count) => count + 1);
  const countDown = () => {
    if (count > 1)
      setCount((count) => {
        return count - 1;
      });
  };
  useEffect(() => {
    if (demoDessertOptions.length > 0) setDessertOption(demoDessertOptions[0]);
    if (demoDrinkOptions.length > 0) setDrinkOption(demoDrinkOptions[0]);
  }, [demoDessertOptions, demoDrinkOptions]);
  if (product == null)
    return (
      <ProductSelector products={group.productList} onSelect={setProduct} />
    );

  return (
    <VStack>
      <HStack className="items-center">
        <img
          className="bg-white w-36 h-36 object-contain rounded-xl shadowed mb-2"
          src={product.image ?? ""}
        />
        <VStack className="text-start ml-4">
          <span className="w-48 font-bold">{product.name}</span>
          <HStack>
            <button
              className="p-0 w-6 h-6 leading-none rounded-xl shadowed"
              onClick={countDown}
            >
              -
            </button>
            <span className="font-bold">{count} 개</span>
            <button
              className="p-0 w-6 h-6 leading-none rounded-xl shadowed"
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
        <Swiper slidesPerView={4} spaceBetween={30} className="!w-96">
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
      )}
      {product.drinkOptionAvailable && (
        <Swiper slidesPerView={4} spaceBetween={30} className="!w-96">
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
      )}
      <Button color={""}>주문담기</Button>
    </VStack>
  );
}

export default ItemSelector;
