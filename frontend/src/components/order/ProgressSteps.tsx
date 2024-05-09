export interface Step {
  label: string;
  step: number;
}
interface ProgressStepsProps {
  step: number;
  steps: Step[];
  onSelect: (step: number) => void;
}

function ProgressSteps({ step, steps, onSelect }: ProgressStepsProps) {
  const totalSteps = steps.length;
  const height = `${(100 * (step - 1)) / (totalSteps - 1)}%`;
  return (
    <div className="flex flex-row h-80 my-auto">
      <div className="flex flex-col items-end justify-between gap-y-10 z-10">
        {steps.map(({ step: myStep, label }) => (
          <div
            key={myStep}
            className={`flex flex-row gap-2 font-bold items-center ${step >= myStep ? "text-blue-500 border-blue-500 cursor-pointer" : "text-blue-200 border-blue-200 cursor-default"}`}
            onClick={() => {
              if (step > myStep) onSelect(myStep);
            }}
          >
            <div className="hidden sm:block">{label}</div>
            <div
              className={`border-4 rounded-full w-8 h-8 text-center bg-white ${step >= myStep ? "border-blue-500" : "border-blue-200"}`}
            >
              {step > myStep ? (
                <div className="rotate-45 -scale-x-100 font-extrabold transition-all">
                  L
                </div>
              ) : (
                <div className="font-bold transition-all">{myStep}</div>
              )}
            </div>
          </div>
        ))}
      </div>
      <div className="w-2 relative right-5 my-2">
        <div className="bg-blue-200 w-full h-full absolute" />
        <div
          className="bg-blue-500 w-full absolute transition-all ease-in-out"
          style={{ height: height }}
        />
      </div>
    </div>
  );
}

export default ProgressSteps;
