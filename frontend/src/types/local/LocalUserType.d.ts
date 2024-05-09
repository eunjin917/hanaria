import CouponType from "../CouponType";

type LocalUserType = {
  memberId: number;
  nickname: string;
  point: number;
  memberCoupons: CouponType[];
};
export default LocalUserType;
