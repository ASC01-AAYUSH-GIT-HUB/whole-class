import logo from './logo.svg';
import './App.css';

const user = {
  name: "Aayush Prasad",
  imageUrl: "https://avatars.githubusercontent.com/u/136549513?v=4",
  imageSize: 90,
};
export default function Ascendion() {
  return (
    <>
      <AddDetails />
    </>
  );
}

function AddDetails() {
  return (
    <>
      <h2>{user.name}</h2>
      <img
        class="myImg"
        src={user.imageUrl}
        style={{
          width: user.imageSize,
          height: user.imageSize,
        }}
      />
    </>
  );
}
