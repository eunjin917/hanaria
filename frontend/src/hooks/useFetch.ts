import { useEffect, useState } from "react";

export function useFetchTrigger<T>() {
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState<string>("");
  const [url, setUrl] = useState<string>("");
  const [data, setData] = useState<T>();

  useEffect(() => {
    if (!url) return;
    console.log(`fetch: ${url}`);
    setIsLoading(true);
    const controller = new AbortController();
    const { signal } = controller;
    (async () => {
      try {
        const res = await fetch(url, { signal });
        if (!res.ok) throw new Error(`error code ${res.status}`);
        const json = await res.json();
        setData(json as T);
        setError("");
      } catch (error) {
        if (error instanceof Error) setError(error.message);
        setIsLoading(false);
      } finally {
        setIsLoading(false);
      }
    })();
    return () => controller.abort(); //강제중지
  }, [url]);

  return {
    data: data,
    error: error,
    isLoading: isLoading,
    trigger: setUrl,
  };
}
