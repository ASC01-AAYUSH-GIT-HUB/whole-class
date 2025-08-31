
const user2 = {
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
      <h2>{user2.name}</h2>
      <img
        class="myImg"
        src={user2.imageUrl}
        style={{
          width: user2.imageSize,
          height: user2.imageSize,
        }}
      />
    </>
  );
}
