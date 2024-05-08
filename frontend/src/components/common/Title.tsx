import { PropsWithChildren } from "react";

interface TitleProps {}

function Title({ children }: PropsWithChildren<TitleProps>) {
  return <span className="font-bold text-lg text-center mb-2">{children}</span>;
}

export default Title;
