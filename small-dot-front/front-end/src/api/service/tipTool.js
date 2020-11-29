import { Toast } from 'antd-mobile'

export const tipError = (error) => {
	Toast.fail(error, 2)
	return null;
};
export const loadingShow = () => {
	Toast.loading('加载中……', 0, null, true)
};
export const loadingHide = () => {
	Toast.hide()
};
