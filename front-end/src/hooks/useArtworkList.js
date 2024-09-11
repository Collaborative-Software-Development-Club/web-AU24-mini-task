import { useEffect, useState } from "react";
import { getArtworkList } from "../data";

export default function useArtworkList(numArtworks) {
	const [data, setData] = useState([]);
	useEffect(() => {
		const setArtworkData = async () => {
			const fetchedData = await getArtworkList(numArtworks);
			setData(fetchedData);
		};
		setArtworkData();
	}, [numArtworks]);
	return data;
}
