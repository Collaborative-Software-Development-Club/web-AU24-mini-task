import useArtworkList from "../hooks/useArtworkList";
import ArtPreview from "./ArtPreview";
import NumberSelector from "./NumberSelector";
import { useState } from "react";

const DEFAULT_NUMBER = 10;

export default function Gallery() {
	const [numArtworks, setNumArtworks] = useState(DEFAULT_NUMBER);
	const data = useArtworkList(numArtworks);
	console.log(numArtworks);
	console.log(data);
	console.log(data.length);
	return (
		<div
			style={{
				height: "100vh",
				display: "flex",
				flexDirection: "column",
				alignItems: "stretch",
				padding: "2rem",
				gap: "1rem",
			}}
		>
			<h1>Lorenzo's Art Gallery</h1>
			<NumberSelector
				setNumArtworks={setNumArtworks}
				numArtworks={numArtworks}
			/>
			<div
				style={{
					display: "flex",
					flexDirection: "row",
					gap: "3rem",
					overflowX: "scroll",
					alignItems: "stretch",
				}}
			>
				{data.map(item => (
					<ArtPreview artwork={item} />
				))}
			</div>
		</div>
	);
}
