import { ButtonHTMLAttributes, PropsWithChildren } from "react";

interface ButtonProps extends ButtonHTMLAttributes<HTMLButtonElement> {}

function Button({
  color,
  className,
  children,
  ...props
}: PropsWithChildren<ButtonProps>) {
  return (
    <button
      className={`hover:scale-105 transition-all px-2 py-4 w-fit rounded-xl ${className}`}
      {...props}
    >
      {children}
    </button>
  );
}

export default Button;
