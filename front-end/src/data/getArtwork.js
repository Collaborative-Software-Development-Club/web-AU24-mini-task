export default async function getArtwork(artworkId) {
	const url = getArtworkEndpointById(artworkId);
	const response = await fetch(url);
	const json = await response.json();
	return parseArtwork(json);
}

// This probably isn't the best way to do it
function parseArtwork(artworkData) {
	if (!isValidArtwork(artworkData)) {
		return undefined;
	}
	console.log(artworkData);
	return {
		title: artworkData.title,
		artist: artworkData.artistDisplayName,
		imageUrl: artworkData.primaryImage,
		id: artworkData.objectID,
		artistBio: artworkData.artistDisplayBio,
		date: artworkData.objectDate,
	};
}

function isValidArtwork(artwork) {
	console.log(artwork);
	if (artwork.message == "Not a valid object") {
		return false;
	}
	if (artwork.primaryImage == "") {
		return false;
	}
	return true;
}

function getArtworkEndpointById(id) {
	const url = `https://collectionapi.metmuseum.org/public/collection/v1/objects/${id}`;
	return url;
}
