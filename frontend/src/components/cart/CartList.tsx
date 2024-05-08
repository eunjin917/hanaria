import { Swiper, SwiperSlide } from "swiper/react";
import LocalItemType from "../../types/local/LocalItemType";
// Import Swiper styles
import "swiper/css";
import "swiper/css/pagination";
import "swiper/css/navigation";
import CartItemCell from "./CartItemCell";

interface CartListProps {
  items: LocalItemType[];
  onChange: (item: LocalItemType, index: number) => void;
  onDelete: (index: number) => void;
}

function CartList({ items, onChange, onDelete }: CartListProps) {
  return (
    /* 장바구니 스와이퍼 */
    <div className="px-2 mb-2 w-full max-w-xl">
      <Swiper slidesPerView={"auto"} className="bg-slate-100 py-5 rounded-xl">
        {items.map((item, index) => (
          <SwiperSlide key={index} className="!w-fit">
            <CartItemCell
              item={item}
              index={index}
              onChange={onChange}
              onDelete={onDelete}
            />
          </SwiperSlide>
        ))}
      </Swiper>
    </div>
  );
}
export default CartList;
