import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Gallery from "./components/Gallery";
import ArtworkPage from "./components/ArtworkPage";

function App() {
	return (
		<BrowserRouter>
			<Routes>
				<Route index element={<Gallery />} />
				<Route path="/:id" element={<ArtworkPage />} />
			</Routes>
		</BrowserRouter>
	);
}

export default App;
