package component;

import java.io.Serializable;
import java.util.Map;
import java.util.Properties;



import javax.persistence.metamodel.IdentifiableType;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.spi.IdentifierValue;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.metamodel.relational.Identifier;
import org.hibernate.tuple.IdentifierAttribute;
import org.hibernate.type.IdentifierType;
import org.hibernate.type.Type;

public class CustomSequenceGenerator implements IdentifierGenerator, Configurable{

	public static final String SEQUENCE_PREFIX = "sequence_prefix";
	
	private String sequencePrefix;
	private String sequenceCallSyntax;

	@Override
	public void configure(
			Type type, 
			Properties props, Dialect dialect)
			throws MappingException {
		
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		final ConfigurationService configurationService = registry.getService(ConfigurationService.class);
		String globalEntityIdentifierPrefix = configurationService.getSetting("entity.identifier.prefix", String.class, "SEQ_");
		sequencePrefix = ConfigurationHelper.getString(SEQUENCE_PREFIX, props, globalEntityIdentifierPrefix);
		
		final String sequencePerEntitySuffix = ConfigurationHelper.getString(SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX, props, SequenceStyleGenerator.DEF_SEQUENCE_SUFFIX);
		final boolean preferSequencePerEntity = ConfigurationHelper.getBooleanWrapper(SequenceStyleGenerator.CONFIG_PREFER_SEQUENCE_PER_ENTITY, props, false);
		
		final String defaultSequenceName = preferSequencePerEntity ? props.getProperty(JPA_ENTITY_NAME) + sequencePerEntitySuffix : SequenceStyleGenerator.DEF_SEQUENCE_NAME;
		
		sequenceCallSyntax = dialect.getSequenceNextValString
					(ConfigurationHelper.getString(SequenceStyleGenerator.SEQUENCE_PARAM, props, defaultSequenceName));
	}

	@Override
	public Serializable generate(SessionImplementor session, Object obj)
			throws HibernateException {
		
//		if(obj instanceof Identifi){
//			IdentifiableType identify = (IdentifiableType) obj;
//			Identifier iden = (IdentifierAttribute)obj;
//			
//			Serializable id = identify.getIdClassAttributes();
//		}
		return null;
	}

}
