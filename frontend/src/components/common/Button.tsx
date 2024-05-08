import { ButtonHTMLAttributes, PropsWithChildren } from "react";

interface ButtonProps extends ButtonHTMLAttributes<HTMLButtonElement> {
  color: string;
}

function Button({
  className,
  children,
  ...props
}: PropsWithChildren<ButtonProps>) {
  return (
    <button
      className={`px-2 py-4 shadowed w-fit rounded-xl ${className}`}
      {...props}
    >
      {children}
    </button>
  );
}

export default Button;
