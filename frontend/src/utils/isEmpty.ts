function isEmpty(obj: Object | undefined) {
  return obj === undefined || Object.keys(obj).length === 0;
}

export default isEmpty;
