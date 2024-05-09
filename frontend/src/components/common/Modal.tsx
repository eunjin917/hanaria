import { HTMLAttributes, PropsWithChildren } from "react";

interface ModalProps extends HTMLAttributes<HTMLDivElement> {
  onClose: () => void;
}

function Modal({ onClose, children, ...props }: PropsWithChildren<ModalProps>) {
  return (
    <div className="w-full h-full">
      <div className="absolute top-0 left-0 z-10 justify-center items-center w-full">
        <div
          className="bg-gray-900/50 dark:bg-gray-900/80 fixed inset-0 z-40"
          onClick={onClose}
        ></div>
        <div
          className="relative bg-white shadowed w-fit h-fit mx-auto my-8 rounded-xl p-4 z-50"
          {...props}
        >
          <button
            className="absolute right-5 z-50 text-gray-500 font-bold font-sans"
            onClick={onClose}
          >
            X
          </button>
          {children}
        </div>
      </div>
    </div>
  );
}
export default Modal;
