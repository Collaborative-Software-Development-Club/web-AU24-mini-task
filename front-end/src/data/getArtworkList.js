import getArtwork from "./getArtwork";

export default async function getArtworkList(numArtworks) {
	const artworkIds = await getArtworkIds(numArtworks);
	const artworksData = await Promise.all(artworkIds.map(getArtwork));
	const valids = artworksData
		.filter(artwork => artwork != undefined)
		.splice(0, numArtworks);
	return valids;
}

async function getArtworkIds(numArtworks) {
	const response = await fetch(ARTWORKS_WITH_IMAGES);
	const json = await response.json();
	const artworksWithImages = json.objectIDs;
	shuffle(artworksWithImages);
	return artworksWithImages.slice(0, numArtworks + BUFFER);
}

function shuffle(array) {
	for (let i = array.length - 1; i > 0; i--) {
		const j = Math.floor(Math.random() * (i + 1));
		[array[i], array[j]] = [array[j], array[i]];
	}
	return array;
}

const ARTWORKS_WITH_IMAGES =
	"https://collectionapi.metmuseum.org/public/collection/v1/search?isHighlight=true&q='painting'";

// only way I found to handle invalid images and have the correct number
const BUFFER = 10;
