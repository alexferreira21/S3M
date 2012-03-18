package service;

import java.util.List;

import hibernate.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import entity.Perfil;
import entity.Usuario;

public class UsuarioService {

	private Session session = HibernateUtil.getInstance().getSession();

	public Usuario login(String login, String senha){

		Criteria query =  session.createCriteria(Usuario.class)
				.add(Restrictions.eq("login", login))
				.add(Restrictions.like("senha", senha));




		Usuario usuarioRetornado = (Usuario)query.uniqueResult();
		return usuarioRetornado;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarios(){

		return (List<Usuario>)session.createCriteria(Usuario.class).list();

	}
	
	public void salvarUsuario(Usuario usuario){
		
		session.beginTransaction();
		
		Perfil perfil = (Perfil)session.createCriteria(Perfil.class).add(Restrictions.eq("idPerfil", usuario.getPerfil().getIdPerfil())).uniqueResult();
		usuario.setPerfil(perfil);
		
		if (usuario.getId() != null) {
			session.saveOrUpdate(usuario);
		}
		else
		{
			session.merge(usuario);
		}
		
		session.getTransaction().commit();
	}

	public void removerUsuario(Usuario usuario){
		
		session.beginTransaction();
		
		usuario = (Usuario)session.createCriteria(Usuario.class).add(Restrictions.eq("id", usuario.getId())).uniqueResult();
		session.delete(usuario);
		
		session.getTransaction().commit();
	}

}
