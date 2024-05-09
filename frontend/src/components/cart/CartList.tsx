import { Swiper, SwiperSlide } from "swiper/react";
import LocalItemType from "../../types/local/LocalItemType";
// Import Swiper styles
import "swiper/css";
import "swiper/css/pagination";
import "swiper/css/navigation";
import CartItemCell from "./CartItemCell";
import { useState } from "react";
import ItemEditor from "../product/ItemEditor";
import Modal from "../common/Modal";

interface CartListProps {
  items: LocalItemType[];
  onChange: (item: LocalItemType, index: number) => void;
  onDelete: (index: number) => void;
}

function CartList({ items, onChange, onDelete }: CartListProps) {
  const [itemToEdit, setItemToEdit] = useState<LocalItemType | null>(null);
  const [indexToEdit, setIndexToEdit] = useState<number | null>(null);
  const editItem = (item: LocalItemType, index: number) => {
    setItemToEdit(item);
    setIndexToEdit(index);
  };
  const cancelEditItem = () => {
    setItemToEdit(null);
    setIndexToEdit(null);
  };
  return (
    <div className="px-2 mb-2 w-full max-w-xl">
      {
        // 장바구니 품목 수정 모달
        itemToEdit && indexToEdit != null && (
          <Modal onClose={cancelEditItem}>
            <ItemEditor
              item={itemToEdit}
              index={indexToEdit}
              onClose={cancelEditItem}
              onSelect={onChange}
            />
          </Modal>
        )
      }
      {/*  장바구니 스와이퍼 */}
      <Swiper
        slidesPerView={"auto"}
        className="bg-slate-100 h-44 py-5 rounded-xl"
      >
        {items.map((item, index) => (
          <SwiperSlide key={index} className="!w-fit transition-all">
            <CartItemCell
              item={item}
              index={index}
              onEdit={editItem}
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
