import { Link } from "react-router-dom";
export default function ArtPreview({ artwork }) {
	return (
		<Link
			style={{
				overflow: "clip",
				display: "flex",
				flexDirection: "column",
			}}
			to={`/${artwork.id}`}
		>
			<img
				style={{
					aspectRatio: "object-fit",
					height: "60%",
					borderRadius: "1rem",
				}}
				src={artwork.imageUrl}
			/>
			<div style={{ padding: "1rem" }}>
				<h2 style={{ overflow: "scroll" }}>
					{artwork.title ?? "No title provided"}
				</h2>
				{artwork.artist && <p>{artwork.artist}</p>}
			</div>
		</Link>
	);
}
