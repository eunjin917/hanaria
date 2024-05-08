import ProductType from "../../types/ProductType";
import { VStack } from "../common/Stack";
import ProductCell from "./ProductCell";

interface ProductSelectorProps {
  products: ProductType[];
  onSelect: (product: ProductType) => void;
}

function ProductSelector({ products, onSelect }: ProductSelectorProps) {
  return (
    <VStack>
      {products.map((product) => (
        <ProductCell
          key={product.id}
          product={product}
          onClick={() => onSelect(product)}
        />
      ))}
    </VStack>
  );
}
export default ProductSelector;
