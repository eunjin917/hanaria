import ProductType from "../../types/ProductType";
import { HStack, VStack } from "../common/Stack";

interface ProductCellProps
  extends React.ButtonHTMLAttributes<HTMLButtonElement> {
  product: ProductType;
}

function ProductCell({ product, ...attributes }: ProductCellProps) {
  return (
    <button
      className="hover:scale-105 m-2 transition-all cursor-pointer"
      {...attributes}
    >
      <HStack className="items-center">
        <img
          className="bg-white w-36 h-36 object-contain rounded-xl shadowed mb-2"
          src={product.image ?? ""}
        />
        <VStack className="text-start ml-4">
          <span className="w-48 font-bold">{product.name}</span>
          <span className="font-semibold text-">
            {(product.price ?? 0).toLocaleString()}원
          </span>
        </VStack>
      </HStack>
    </button>
  );
}

export default ProductCell;
