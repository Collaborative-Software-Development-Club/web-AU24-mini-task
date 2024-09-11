import { getArtwork } from "../data";
import { useState, useEffect } from "react";
export default function useArtwork(id) {
	const [data, setData] = useState(null);
	useEffect(() => {
		const setArtworkData = async () => {
			const fetchedData = await getArtwork(id);
			setData(fetchedData);
		};
		setArtworkData();
	}, []);
	return data;
}
