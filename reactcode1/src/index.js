import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./styles.css";

import Ascendion from "./App";

const root = createRoot(document.getElementById("root"));
root.render(
  <StrictMode>
    <Ascendion />
  </StrictMode>
);
