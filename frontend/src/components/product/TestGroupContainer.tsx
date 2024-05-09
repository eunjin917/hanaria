import { HStack } from "../common/Stack";
import { Swiper, SwiperSlide } from "swiper/react";
import SwiperCore from "swiper"; // 타입지정을 위해 필요하다.
// Import Swiper styles
import "swiper/css";
import "swiper/css/pagination";
import "swiper/css/navigation";
// import required modules
import { Pagination, Navigation, Controller } from "swiper/modules";
import { useEffect, useState } from "react";
import CategorySelector from "./CategorySelector";
import GroupType from "../../types/GroupType";
import TestGroupPage from "./TestGroupPage";
import CategoryType from "../../types/CategoryType";
import demoCategories, {
  demoCategoryPages,
} from "../../types/demos/demoCategories";

type PageInfo = {
  index: number;
  categoryId: number;
  categoryName: string;
  categoryIndex: number;
  groups: GroupType[];
};

interface GroupContainerProps {
  onSelect: (group: GroupType) => void;
}

function TestGroupContainer({ onSelect }: GroupContainerProps) {
  const [swiper, setSwiper] = useState<SwiperCore>();
  const [selectedCategory, setSelectedCategory] = useState<number>();
  const [categories, setCategories] = useState<CategoryType[]>([]); // 카테고리 -> 페이지 넘버
  const [pages, setPages] = useState<PageInfo[]>([]); // 페이지 정보

  //스와이퍼 페이지 동적으로 로드
  const loadPage = (page: PageInfo) => {
    const pagesDraft: PageInfo[] = [...pages];
    pagesDraft[page.index] = {
      ...pagesDraft[page.index],
      groups: demoCategoryPages[page.categoryId],
    };
    setPages(pagesDraft);
  };

  //페이지 로드 시 상품그룹 메타데이터 가져오기
  useEffect(() => {
    setCategories(demoCategories);
  }, []);

  //그룹정보,상품목록 -> 카테고리별 상품 페이지들
  useEffect(() => {
    if (categories.length == 0) return;
    console.log(categories);
    const pagesDraft: PageInfo[] = [];
    let pageCnt: number = 0;
    for (const category of categories) {
      for (let i = 0; i < category.pageCnt; i++) {
        let emptyPage: PageInfo = {
          index: pageCnt,
          categoryId: category.id,
          categoryName: category.name,
          categoryIndex: i,
          groups: [],
        };
        console.log(emptyPage);
        pagesDraft.push(emptyPage);
        pageCnt += 1;
      }
    }
    setPages(pagesDraft);
  }, [categories]);

  useEffect(() => {
    if (pages.length > 0 && pages[0].groups.length == 0) {
      loadPage(pages[0]);
    }
  }, [pages]);

  return (
    <div className="mx-auto max-w-xl">
      {/* 카테고리 선택 버튼들 */}
      <HStack className="mx-2 mt-2">
        {categories.map((category) => (
          <CategorySelector
            key={category.id}
            text={category.name}
            selected={selectedCategory === category.id}
            onClick={() => {
              swiper?.slideTo(category.startIndex);
            }}
          />
        ))}
      </HStack>
      {/* 상품 목록 스와이퍼 */}
      <Swiper
        slidesPerView={1}
        spaceBetween={30}
        pagination={{
          clickable: true,
        }}
        navigation={true}
        modules={[Pagination, Navigation, Controller]}
        onSwiper={setSwiper}
        controller={{ control: swiper }}
        onSlideChange={(swiper) => {
          //선택된 그룹 바꿔야한다면 바꾸기
          setSelectedCategory(pages[swiper.realIndex].categoryId);
          //상품목록 동적으로 로드
          if (pages[swiper.realIndex].groups.length == 0) {
            loadPage(pages[swiper.realIndex]);
          }
        }}
      >
        {/* 페이지들 */}
        {pages.map((page, pageIdx) => (
          <SwiperSlide key={pageIdx}>
            <TestGroupPage groups={page.groups} onSelect={onSelect} />
          </SwiperSlide>
        ))}
      </Swiper>
    </div>
  );
}

export default TestGroupContainer;
