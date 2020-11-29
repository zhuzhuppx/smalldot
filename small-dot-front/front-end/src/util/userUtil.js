const key = "react-user-key";
export const setUser = user => {
  localStorage.setItem(key, JSON.stringify(user));
};
export const getUser = () => {
  return JSON.parse(localStorage.getItem(key));
};
