import useArtwork from "../hooks/useArtwork";
import { Link } from "react-router-dom";
import { useParams } from "react-router-dom";
export default function ArtworkPage() {
	const { id } = useParams();
	const artwork = useArtwork(id);
	console.log(artwork);
	if (!artwork) {
		return <p>Loading</p>;
	}
	return (
		<div
			style={{
				display: "flex",
				flexDirection: "column",
				padding: "2rem",
				gap: "1rem",
				alignItems: "start",
			}}
		>
			<Link to="/">👈Back to Gallery</Link>
			<h1>{artwork.title ?? "(no title provided)"}</h1>
			<p>{artwork.date ?? "Date unavailable"}</p>
			<p>
				{artwork.artist ?? "Unidentified artist"}
				{artwork.artist &&
					artwork.artistBio &&
					`- ${artwork.artistBio}`}
			</p>
			<img
				style={{ height: "70vh", objectFit: "contain" }}
				src={artwork.imageUrl}
			/>
		</div>
	);
}
