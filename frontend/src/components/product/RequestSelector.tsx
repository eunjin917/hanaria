import RequestType from "../../types/RequestType";
import {
  demoBurgerReqeusts,
  demoDessertReqeusts,
  demoDrinkReqeusts,
} from "../../types/demos/demoRequests";
import { VStack } from "../common/Stack";

interface RequestSelectorProps {
  requests: number;
  onSelect: (requestBits: number) => void;
}

function RequestSelecor({ requests, onSelect }: RequestSelectorProps) {
  const requestList: RequestType[] = [
    ...demoBurgerReqeusts,
    ...demoDessertReqeusts,
    ...demoDrinkReqeusts,
  ];
  const toggleRequest = (bit: number) => {
    if (requests & bit) {
      onSelect(requests ^ bit);
    } else {
      onSelect(requests | bit);
    }
  };
  return (
    <VStack className="w-96 gap-4 rounded-xl">
      {requestList.map((request) => (
        <button key={request.id} onClick={() => toggleRequest(request.bit)}>
          {requests & request.bit ? (
            <div
              className={`text-start p-2 w-96 text-lg font-semibold text-black border border-blue-400 rounded-xl shadowed`}
            >
              {request.body}
            </div>
          ) : (
            <div
              className={`text-start p-2 w-96 text-lg text-gray border border-transparent rounded-xl shadowed`}
            >
              {request.body}
            </div>
          )}
        </button>
      ))}
    </VStack>
  );
}

export default RequestSelecor;
