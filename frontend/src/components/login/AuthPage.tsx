import { useRef, useState } from "react";
import LocalUserType from "../../types/local/LocalUserType";
import { HStack, VStack } from "../common/Stack";
import Title from "../common/Title";
import Button from "../common/Button";

interface AuthPageProps {
  onLogin: (user: LocalUserType) => void;
}

function AuthPage({ onLogin }: AuthPageProps) {
  const [isLogining, setIsLogining] = useState<boolean>(true);

  const loginUsernameRef = useRef(null);
  const loginPasswordRef = useRef(null);
  const registerUsernameRef = useRef(null);
  const registerPasswordRef = useRef(null);
  const registerNicknameRef = useRef(null);
  const registerTelRef = useRef(null);

  return (
    <VStack className="w-96 items-center">
      <HStack className="mb-2">
        <Button
          className="py-1 bg-blue-50 text-blue-400 font-bold"
          onClick={() => setIsLogining(true)}
        >
          로그인
        </Button>
        <Button
          className="py-1 bg-blue-50 text-blue-400 font-bold"
          onClick={() => setIsLogining(false)}
        >
          회원가입
        </Button>
      </HStack>
      {isLogining ? (
        <VStack className="items-center">
          <Title>로그인</Title>
          <form className="flex flex-col leading-none">
            <label className="flex flex-row items-center w-72 justify-between font-bold mb-2">
              아이디
              <input
                ref={loginUsernameRef}
                id="loginUsername"
                className="border border-black rounded-md p-1"
              />
            </label>
            <label className="flex flex-row items-center w-72 justify-between font-bold mb-2">
              패스워드
              <input
                type="password"
                ref={loginPasswordRef}
                id="loginPassword"
                className="border border-black rounded-md p-1"
              />
            </label>
          </form>
          <Button className="py-1 bg-yellow-200 font-bold" onClick={() => {}}>
            로그인
          </Button>
        </VStack>
      ) : (
        <VStack className="items-center">
          <Title>회원가입</Title>
          <form className="flex flex-col leading-none">
            <label className="flex flex-row items-center w-72 justify-between font-bold mb-2">
              아이디
              <input
                ref={registerUsernameRef}
                id="registerUsername"
                className="border border-black rounded-md p-1"
              />
            </label>
            <label className="flex flex-row items-center w-72 justify-between font-bold mb-2">
              패스워드
              <input
                type="password"
                ref={registerPasswordRef}
                id="registerPassword"
                className="border border-black rounded-md p-1"
              />
            </label>
            <label className="flex flex-row items-center w-72 justify-between font-bold mb-2">
              닉네임
              <input
                type="text"
                ref={registerNicknameRef}
                id="registerNickname"
                className="border border-black rounded-md p-1"
              />
            </label>
            <label className="flex flex-row items-center w-72 justify-between font-bold mb-2">
              전화번호
              <input
                type="tel"
                ref={registerTelRef}
                id="registerTel"
                className="border border-black rounded-md p-1"
              />
            </label>
          </form>
          <Button className="py-1 bg-yellow-200 font-bold" onClick={() => {}}>
            로그인
          </Button>
        </VStack>
      )}
    </VStack>
  );
}
export default AuthPage;
