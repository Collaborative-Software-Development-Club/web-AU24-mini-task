const MAX = 20;
const MIN = 1;

export default function NumberSelector({ setNumArtworks, numArtworks }) {
	function handleChange(e) {
		const value = e.target.value;
		if (value === "") {
			return;
		}
		if (value === NaN) {
			return;
		}
		const asNumber = parseInt(e.target.value);
		if (asNumber < MIN || asNumber > MAX) {
			alert(`Number has to be between ${MIN} and ${MAX}`);
			return;
		}
		setNumArtworks(asNumber);
	}
	return (
		<p>
			Showing{" "}
			<input
				type="number"
				style={{ alignSelf: "start" }}
				value={numArtworks}
				onChange={handleChange}
				min={MIN}
				max={MAX}
			/>{" "}
			artworks
		</p>
	);
}
