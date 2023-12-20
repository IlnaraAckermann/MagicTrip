import UserCard from "@/components/cards/UserCard";
import PageHead from "@/components/head/Head";
import GetUsers from "@/hooks/getUsers";


const ListarUsuarios = () => {
  const {user} = GetUsers();
  
      return (
      <>
      <PageHead titulo="Usuários Mágicos!" />
        <div className='container'>
          <h1>Nossos usuarios</h1>
          <section className="my-5 ">
          <h2 className="text-center mb-3">Destinos Mágicos</h2>
          <div className="row">
            {user.map((user, i) => (
              <div className="col-lg-3 col-md-4 col-sm-6 col-12 mb-3"   key={i}>
              <UserCard
                user={user}
              />
              </div>
            ))}
          </div>
        </section>
        </div>
      </>
      );
    };
    
    export default ListarUsuarios;