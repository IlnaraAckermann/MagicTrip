import PageHead from "@/components/head/Head";
import getDestinos from "@/hooks/getDestinos";
import DestineCard from "@/components/cards/DestineCard";
import PromotionCard from "@/components/cards/PromotionCard";

const Destinos = () => {
  const { destinos } = getDestinos();

  return (
    <>
      <PageHead titulo="MagicTrip - Viaje, sonhe, encante-se!" />
      <main className="content-fluid m-3">
        <section>
          <div className="my-3">
            <h2>Destinos</h2>
          </div>
        <div className="row">
          {destinos.slice(0, 6).map((destino, i) => (
            <div className="col-lg-4 col-sm-6 mb-3"   key={i}>
              <DestineCard destino={destino} />
            </div>
          ))}
        </div>
          </section>
          <section>
          <div className="my-3">
            <h2>Pormoções</h2>
          </div>
        <div className="row">
          {destinos.slice(4).map((destino, i) => (
            <div className="col-lg-4 col-sm-6 mb-3"   key={i}>
              <PromotionCard destino={destino} />
            </div>
          ))}
        </div>
          </section>
      </main>
    </>
  );
};

export default Destinos;
